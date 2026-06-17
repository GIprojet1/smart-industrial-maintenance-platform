package com.example.demo.ws;
import com.example.demo.service.CentralSystemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/central-system")
@CrossOrigin(origins = "http://localhost:3000")
public class CentralSystemWs {

    private final CentralSystemService centralSystemService;

    public CentralSystemWs(
            CentralSystemService centralSystemService
    ) {
        this.centralSystemService =
                centralSystemService;
    }
    // =====================================
    // SYNC DATA FROM CENTRAL SYSTEM
    // =====================================

    @PostMapping("/sync")
    public String synchronizeData() {

        centralSystemService
                .synchronizeData();

        return "Data synchronized successfully";
    }
}