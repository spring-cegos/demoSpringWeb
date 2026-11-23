package fr.cegos.demospringweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
class ContactController {

    @GetMapping
    public String contacts() {
        // contacts doit correspondre à un template présent dans le dossier resources/templates
        // ici, on a le moteur de template Mustache, Spring va chercher un template nommé contacts.mustache
        return "contacts";
    }

    /**
     * Je veux une route pour créer un nouveau contact
     * @GetMapping("/nouveau") va ajouter /nouveau à la route définir par le Requestmapping de mon controller (/contacts)
     * => http://localhost:8080/contacts/nouveau
     */
    @GetMapping("/nouveau")
    public String nouveauContact() {
        // contacts doit correspondre à un template présent dans le dossier resources/templates
        // ici, on a le moteur de template Mustache, Spring va chercher un template nommé contactForm.mustache
        return "contactForm";
    }

    /**
     * Méthode appelée lrosque j'effectue une requête de type POST
     * à la route /contacts/nouveau 'lorsque je valide le formulaire de création de contact)
     */
    @PostMapping("/nouveau")
    public String creerNouveauContact(String nom,Model model) {

        // si jamais le paramètre est non vide, j'ajoute un attribut au modèle
        if (!nom.isBlank()){
            model.addAttribute("contact", nom);
        }
        return "contactForm";
    }

}
