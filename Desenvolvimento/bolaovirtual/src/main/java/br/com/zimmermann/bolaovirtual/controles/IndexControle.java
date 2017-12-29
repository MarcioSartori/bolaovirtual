/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zimmermann.bolaovirtual.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Marcio
 */
@Controller
public class IndexControle {
    
    @RequestMapping(value="/index")
    public String executaIndex(){
        return "index";
    }
}
