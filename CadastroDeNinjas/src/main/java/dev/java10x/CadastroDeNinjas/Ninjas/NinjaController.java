package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/Boasvindas")
    public String BoasVindas() {
        return "Esta é minha primeira mensagem nesta rota";
    }


}
