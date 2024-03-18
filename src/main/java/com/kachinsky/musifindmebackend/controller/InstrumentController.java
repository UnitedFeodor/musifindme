package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.instrument.CreateUpdateInstrumentDto;
import com.kachinsky.musifindmebackend.dto.instrument.FlatInstrumentDto;
import com.kachinsky.musifindmebackend.dto.instrument.FullInstrumentDto;
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
    public List<FlatInstrumentDto> getAllInstruments() {
        return instrumentService.getAllInstruments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullInstrumentDto getInstrumentById(@PathVariable("id") int id) {
        return instrumentService.getInstrumentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FullInstrumentDto createInstrument(@RequestBody CreateUpdateInstrumentDto createUpdateInstrumentDto) {
        return instrumentService.createInstrument(createUpdateInstrumentDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullInstrumentDto updateInstrumentById(
            @PathVariable("id") Integer id,
            @RequestBody CreateUpdateInstrumentDto createUpdateInstrumentDto) {
        return instrumentService.updateInstrumentById(id, createUpdateInstrumentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstrumentById(@PathVariable("id") Integer id) {
        instrumentService.deleteInstrumentById(id);
    }
}
