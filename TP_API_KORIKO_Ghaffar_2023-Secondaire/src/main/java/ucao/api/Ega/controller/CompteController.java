package ucao.api.Ega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucao.api.Ega.entity.Client;
import ucao.api.Ega.entity.Compte;
import ucao.api.Ega.entity.Operation;
import ucao.api.Ega.service.ClientService;
import ucao.api.Ega.service.CompteService;

import java.util.List;

@RestController
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping("/comptes")
    public List<Compte> listeCompte(){
        return compteService.showCompte();
    }
    @GetMapping("/comptes/{id}")
    public Compte getCompte(@PathVariable Integer id){
        return compteService.getOneCompte(id);
    }
    @PostMapping("/comptes")
    public Compte saveCompte(@RequestBody Compte compte){
        return compteService.saveCompte(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte updateCompte(@PathVariable Integer id, Compte compte){
        compte.setId(id);
        return compteService.saveCompte(compte);
    }
    @DeleteMapping("/comptes/{id}")
    public void supprimerCompte(@PathVariable Integer id){
        compteService.deleteCompte(id);
    }

    @PostMapping("/comptes/{id}/versements")
    public void effectuerVersement(@PathVariable Integer id, @RequestParam double montant) {
        compteService.effectuerVersement(id, montant);
    }

    @PostMapping("/comptes/{id}/retraits")
    public void effectuerRetrait(@PathVariable Integer id, @RequestParam double montant) {
        compteService.effectuerRetrait(id, montant);
    }

    @PostMapping("/comptes/virements")
    public void effectuerVirement(@RequestParam Integer compteEmetteurId, @RequestParam Integer compteBeneficiaireId, @RequestParam double montant) {
        compteService.effectuerVirement(compteEmetteurId, compteBeneficiaireId, montant);
    }

    @GetMapping("/clients/{clientId}/comptes")
    public List<Compte> getComptesByClient(@PathVariable Integer clientId) {
        return compteService.getComptesByClient(clientId);
    }

    @GetMapping("/comptes/{compteId}/depots")
    public List<Operation> getDepotsByCompte(@PathVariable Integer compte_id) {
        return compteService.getDepotsByCompte(compte_id);
    }

    @GetMapping("/comptes/{compteId}/retraits")
    public List<Operation> getRetraitsByCompte(@PathVariable Integer compte_id) {
        return compteService.getRetraitsByCompte(compte_id);
    }
}
