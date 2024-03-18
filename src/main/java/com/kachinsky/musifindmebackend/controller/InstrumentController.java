package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.instrument.CreateUpdateInstrumentDto;
import com.kachinsky.musifindmebackend.dto.instrument.InstrumentDto;
import com.kachinsky.musifindmebackend.service.InstrumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
@RequiredArgsConstructor
@Slf4j
public class InstrumentController {
    private final InstrumentService instrumentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InstrumentDto> getAllInstruments() {
        return instrumentService.getAllInstruments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstrumentDto getInstrumentById(@PathVariable("id") int id) {
        return instrumentService.getInstrumentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstrumentDto createInstrument(@RequestBody CreateUpdateInstrumentDto createUpdateInstrumentDto) {
        return instrumentService.createInstrument(createUpdateInstrumentDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstrumentDto updateInstrument(
            @PathVariable("id") Integer id,
            @RequestBody CreateUpdateInstrumentDto createUpdateInstrumentDto) {
        return instrumentService.updateInstrument(id, createUpdateInstrumentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstrument(@PathVariable("id") Integer id) {
        instrumentService.deleteInstrument(id);
    }
}
