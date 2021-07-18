package com.rh.service;

import java.util.List;
import java.util.Optional;

import com.rh.entity.Candidate;
import com.rh.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public void saveCandidate(Candidate Candidate) {
        this.candidateRepository.save(Candidate);
    }

    @Override
    public Candidate getCandidateById(long id) {
        Optional<Candidate> optional = candidateRepository.findById(id);
        Candidate Candidate = null;
        if (optional.isPresent()) {
            Candidate = optional.get();
        } else {
            throw new RuntimeException(" Candidate not found for id :: " + id);
        }
        return Candidate;
    }

    @Override
    public void deleteCandidateById(long id) {
        this.candidateRepository.deleteById(id);
    }

    @Override
    public Page<Candidate> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.candidateRepository.findAll(pageable);
    }
}
