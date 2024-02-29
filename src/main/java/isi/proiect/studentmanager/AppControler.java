package isi.proiect.studentmanager;



import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller
public class AppControler {

    @Autowired
    private ElevDAO dao;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private IstoricDAO istoricDAO;
    private String rol="none";
    private User user;

    private List<Map<String, Object>> rows ;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/data")
    public String viewHomePage(Model model)
    {
        List<Elev> listaElevi = dao.list();
        model.addAttribute("listaElevi",listaElevi);

        model.addAttribute("userType",rol);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A vazut datele"));
        return "data";
    }
    @RequestMapping("/bursieri")
    public String viewBursieri(Model model)
    {
        List<Elev> listaElevi = dao.bursieri();
        model.addAttribute("listaElevi",listaElevi);

        model.addAttribute("userType",rol);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A vazut bursierii"));
        return "data";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model)
    {
        Elev elev = new Elev();
        model.addAttribute("elev",elev);
        model.addAttribute("userType",rol);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A creeat un elev"));
        return "new_elev_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("elev") Elev elev)
    {
        dao.save(elev);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A salvat un elev"));
        return "redirect:/data";
    }
    @RequestMapping("/edit/{nr_matricol}")
    public ModelAndView showEditForm(@PathVariable(name="nr_matricol") int nr_matricol)
    {
        ModelAndView mav = new ModelAndView("edit_elev_form");
        Elev elev = dao.get(nr_matricol);
        mav.addObject("elev",elev);
        mav.addObject("userType",rol);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A editat un elev"));
        return mav;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("elev") Elev elev)
    {
        dao.update(elev);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A salvat editul unui elev"));
        return "redirect:/data";
    }
    @RequestMapping("/delete/{nr_matricol}")
    public String delete(@PathVariable(name="nr_matricol") int nr_matricol)
    {
        dao.delete(nr_matricol);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A sters un elev"));
        return "redirect:/data";
    }


    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("error", "");
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            Model model) {

        if (userDAO.get(email, password) == null) {
            model.addAttribute("error", "Invalid email or password. Please try again.");
            return "login";
        } else {
            user=userDAO.get(email, password);

            if(userDAO.getRol(email,password,"admin")!=null)
            {
                rol="admin";
                istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: sign-in"));
                return "redirect:/data";
            }
            else{
                rol="sec";
                istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: sign-in"));
                return "redirect:/data";
            }
        }
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        rol="none";
        model.addAttribute("logout", "Logout");
        //istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: S-a delogat"));
        return "login";
    }

    @RequestMapping("/register")
    public String showNewFormUser(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);

        return "reg_user";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user)
    {
        userDAO.save(user);
        return "redirect:/login";
    }

    @RequestMapping("/istoric")
    public String viewIstoric(Model model)
    {
        List<Istoric> istoricList = istoricDAO.list();
        model.addAttribute("istoricList",istoricList);
        model.addAttribute("userType",rol);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A vazut istoricul"));
        return "istoric";
    }

    @GetMapping("data/applyFilters")
    public String applyFilters(
            @RequestParam(required = false) String classCode,
            @RequestParam(required = false) Double minMedie,
            @RequestParam(required = false) Double maxMedie,
            @RequestParam(required = false) Boolean bursier,
            @RequestParam(required = false) Boolean nonbursier,
            @RequestParam(required = false) String medieOrder,

            Model model) {

        List<Elev> filteredElevi = dao.filterElev(classCode, minMedie, maxMedie,bursier,nonbursier,medieOrder);
        model.addAttribute("userType",rol);
        model.addAttribute("listaElevi", filteredElevi);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A filtrat elevii"));
        return "data";
    }
    @GetMapping("/data/findElev")
    public String applyFilters(
            @RequestParam(required = false) String nrMatricol,

            Model model) {
            model.addAttribute("userType",rol);
            List<Elev> filteredElevi = dao.cautaElev(nrMatricol);
            model.addAttribute("listaElevi", filteredElevi);
            istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A cautat un elev"));
            return "data";


    }
    @GetMapping("/rapoarte")
    public String rapoarte(@RequestParam (required = false ) String reportType, Model model) {


        //System.out.println(reportType);

        if("burse_per_profil".equals(reportType))
        {
            rows = new ArrayList(dao.getBurse_per_profil());
        }
        else if("burspe_per_tip_bursa".equals(reportType)){
            rows = new ArrayList(dao.getBursepe_per_tip_bursa());
        }
        else if("valoare_burse_per_student".equals(reportType))
        {
            rows = new ArrayList(dao.getValoare_burse_per_student());
        }
        else if("nr_total_bursieri".equals(reportType))
        {
            rows = new ArrayList(dao.getNr_total_bursieri());
        }
        else if("nr_total_nonbursieri".equals(reportType))
        {
            rows = new ArrayList(dao.getNr_total_nebursieri());
        }
        else{
            rows =new ArrayList();
            rows.add(Map.of("Rapoarte", "negenerate", "Select", "Alege un tip din cele prezentate"));

        }
        //System.out.println(rows);
        List<String> headers = new ArrayList<>(rows.get(0).keySet());

        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        model.addAttribute("userType",rol);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A facut rapoarte pe date"));

        return "rapoarte";
    }

    @GetMapping("/export/pdf")
    public ResponseEntity<byte[]> exportToPdf(Model model) throws IOException {

        List<String> headers = new ArrayList<>(rows.get(0).keySet());
        PdfExportUtil pdf= new PdfExportUtil();
        ByteArrayOutputStream pdfOutputStream = null;
        try {
            pdfOutputStream = pdf.createPdf(headers, rows);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_PDF);
        headers1.setContentDispositionFormData("attachment", "exported_data.pdf");
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A exportat date"));

        return new ResponseEntity<>(pdfOutputStream.toByteArray(), headers1, HttpStatus.OK);
    }
    @GetMapping("/export/excel")
    public ResponseEntity<byte[]> exportToExcel(Model model) throws IOException {
        List<String> headers = new ArrayList<>(rows.get(0).keySet());
        ExcelExportUtil excel = new ExcelExportUtil();
        ByteArrayOutputStream excelOutputStream = excel.createExcel(headers, rows);

        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers1.setContentDispositionFormData("attachment", "exported_data.xlsx");
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A exportat date"));

        return new ResponseEntity<>(excelOutputStream.toByteArray(), headers1, HttpStatus.OK);
    }





    @GetMapping("/bursieriALL")
    public String bursieri( Model model) {
        List<Map<String, Object>> rows = dao.getBursieri(); ;
        List<String> headers = new ArrayList<>(rows.get(0).keySet());
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);

        List<Map<String, Object>> rows_burse = dao.getBurse(); ;
        List<String> headers_burse = new ArrayList<>(rows_burse.get(0).keySet());
        model.addAttribute("headers_burse",headers_burse);
        model.addAttribute("rows_burse",rows_burse);

        model.addAttribute("userType",rol);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A vazut date bursierilor"));

        return "bursieriALL";
    }
    @GetMapping("/chart")
    public String getPieChart(Model model) {
        model.addAttribute("userType",rol);
        List<Map<String, Object>> originalList = dao.getValoareBursePerClase();
        List<Map<String, Object>> originalList1 = dao.getValoareBursePerSpecializare();
        Map<String, Integer> graphData = new TreeMap<>();

        for (Map<String, Object> map : originalList) {
            String clasa = (String) map.get("Nume Clase");
            Number sumaPerClasa = (Number) map.get("Suma per Clasa");

            if (clasa != null && sumaPerClasa != null) {
                Integer sumaPerClasaInt = sumaPerClasa.intValue();

                graphData.put(clasa, sumaPerClasaInt);
            }
        }

        Map<String, Integer> graphData1 = new TreeMap<>();

        for (Map<String, Object> map1 : originalList1) {
            String clasa1 = (String) map1.get("Nume Specializare");
            Number sumaPerClasa1 = (Number) map1.get("Suma per Spercializare");

            if (clasa1 != null && sumaPerClasa1 != null) {
                Integer sumaPerClasaInt1 = sumaPerClasa1.intValue();

                graphData1.put(clasa1, sumaPerClasaInt1);
            }
        }
        model.addAttribute("userType",rol);
        model.addAttribute("chartData", graphData);
        model.addAttribute("chartData1", graphData1);
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A vazut graficele"));

        return "chart";
    }


    List<List<String>> extractedData;
    @RequestMapping("/uploadForm")
    public String showUploadForm(Model model ) {

        model.addAttribute("extractedTextLines", extractedData);
        model.addAttribute("userType",rol);
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        istoricDAO.save(new Istoric(user.getEmail(),"Eveniment: A incarcat un  fisier"));
        model.addAttribute("userType",rol);
        try {
            if (file.isEmpty()) {
                return "redirect:/uploadForm?error=Empty file";
            }

            extractedData = new ArrayList<>();

            try (InputStream inputStream = file.getInputStream()) {
                if (file.getOriginalFilename().toLowerCase().endsWith(".pdf")) {
                    // Handle PDF file
                    PDDocument document = PDDocument.load(inputStream);
                    PDFTextStripper textStripper = new PDFTextStripper();

                    // Extract text line by line
                    for (String line : textStripper.getText(document).split("\\r?\\n")) {
                        extractedData.add(List.of(line.split("\t")));
                    }

                    document.close();
                } else if (file.getOriginalFilename().toLowerCase().endsWith(".xlsx")) {
                    // Handle Excel file
                    Workbook workbook = new XSSFWorkbook(inputStream);
                    Sheet sheet = workbook.getSheetAt(0);

                    // Iterate over rows
                    Iterator<Row> iterator = sheet.iterator();
                    while (iterator.hasNext()) {
                        Row currentRow = iterator.next();
                        List<String> rowData = new ArrayList<>();

                        // Iterate over cells
                        Iterator<Cell> cellIterator = currentRow.iterator();
                        while (cellIterator.hasNext()) {
                            Cell currentCell = cellIterator.next();
                            rowData.add(currentCell.toString());
                        }

                        extractedData.add(rowData);
                    }

                    workbook.close();
                } else {
                    return "redirect:/uploadForm?error=Invalid file format";
                }

                model.addAttribute("extractedTextLines", extractedData);
            }

            return "redirect:/uploadForm";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/uploadForm?error=Error processing the file";
        }
    }



}




