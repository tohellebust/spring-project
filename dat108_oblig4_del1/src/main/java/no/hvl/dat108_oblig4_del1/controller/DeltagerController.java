package no.hvl.dat108_oblig4_del1.controller;
import jakarta.validation.Valid;
import no.hvl.dat108_oblig4_del1.model.Deltager;
import no.hvl.dat108_oblig4_del1.repository.DeltagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.List;

@Controller
public class DeltagerController {

    private final DeltagerRepo deltagerRepo;

    @Autowired
    public DeltagerController(DeltagerRepo deltagerRepo) {
        this.deltagerRepo = deltagerRepo;
    }

    @GetMapping("/paamelding")
    public String showSignUpForm() {
        return "paamelding";
    }

    @PostMapping("/paamelding")
    public String processSignUp(
            @Valid Deltager deltager,
            BindingResult bindingResult,
            @RequestParam String passordRepetert,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "paamelding";
        }

        if (deltagerRepo.findByMobil(deltager.getMobil()) != null) {
            redirectAttributes.addFlashAttribute("errormessage", "Mobilnummeret er allerede i bruk.");
            return "redirect:/paamelding";
        }

        if (!deltager.getPassord().equals(passordRepetert)) {
            redirectAttributes.addFlashAttribute("errormessage", "Passordene samsvarer ikke");
            return "redirect:/paamelding";
        }

        deltagerRepo.save(deltager);
        redirectAttributes.addFlashAttribute("paameldtDeltager", deltager);
        return "redirect:/paameldt";
    }

    @GetMapping("/deltagerliste")
    public String showParticipantList(Model model) {

        // 1. Henter alle deltagere fra deltager repo
        List<Deltager> deltagere = deltagerRepo.findAll();

        // 2. Sorterer listen på fornavn deretter etternavn
        deltagere.sort(
                Comparator.comparing(Deltager::getFornavn)
                        .thenComparing(Deltager::getEtternavn));

        // 3. Legger den sorterte listen til i modellen.
        model.addAttribute("deltagere", deltagere);

        // 4. Returner navnet på filen som skal vise listen.
        return "deltagerliste";
    }

    @GetMapping("/paameldt")
    public String showConfirmation() {
        return "paameldt";
    }

}
