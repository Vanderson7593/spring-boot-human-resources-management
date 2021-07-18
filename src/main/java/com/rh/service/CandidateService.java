package com.rh.service;

import java.util.List;

import com.rh.entity.Candidate;
import org.springframework.data.domain.Page;

public interface CandidateService {
    List<Candidate> getAllCandidates();

    void saveCandidate(Candidate candidate);

    Candidate getCandidateById(long id);

    void deleteCandidateById(long id);

    Page<Candidate> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
