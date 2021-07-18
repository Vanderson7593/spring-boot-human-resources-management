package com.rh.controller;

import java.util.List;

import com.rh.entity.Absense;
import com.rh.entity.Candidate;
import com.rh.entity.Vacation;
import com.rh.service.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("candidates", candidateService.getAllCandidates());
        return "candidates/all";
    }

    @GetMapping("/new")
    public String showNewCandidateForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "candidates/new";
    }

    @PostMapping("/save")
    public String saveCandidate(@ModelAttribute("candidate") Candidate candidate) {

        candidateService.saveCandidate(candidate);
        return "redirect:/candidates/all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);

        model.addAttribute("candidate", candidate);
        model.addAttribute("vacation", new Vacation());
        model.addAttribute("absense", new Absense());
        return "candidates/details";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);

        model.addAttribute("candidate", candidate);
        return "candidates/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable(value = "id") long id) {

        this.candidateService.deleteCandidateById(id);
        return "redirect:/candidates/all";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page<Candidate> page = candidateService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Candidate> listCandidates = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listCandidates", listCandidates);
        return "index";
    }
}
