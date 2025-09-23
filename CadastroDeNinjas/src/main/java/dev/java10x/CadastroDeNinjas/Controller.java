package dev.java10x.CadastroDeNinjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/Boasvindas")
    public String BoasVindas() {
        return "Esta é minha primeira mensagem nesta rota";
    }


}
