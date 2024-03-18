package com.kachinsky.musifindmebackend.service;


import com.kachinsky.musifindmebackend.dto.instrument.CreateUpdateInstrumentDto;
import com.kachinsky.musifindmebackend.dto.instrument.FlatInstrumentDto;
import com.kachinsky.musifindmebackend.dto.instrument.FullInstrumentDto;
import com.kachinsky.musifindmebackend.entity.Instrument;
import com.kachinsky.musifindmebackend.exception.ResourceNotFoundException;
import com.kachinsky.musifindmebackend.mapper.InstrumentDtoMapper;
import com.kachinsky.musifindmebackend.repository.InstrumentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstrumentService {
    private final InstrumentRepository instrumentRepository;
    private final InstrumentDtoMapper instrumentDtoMapper;

    @Transactional
    public List<FlatInstrumentDto> getAllInstruments() {
        List<Instrument> instruments = instrumentRepository.findAll();
        return instrumentDtoMapper.toDto(instruments);
    }
    @Transactional
    public FullInstrumentDto getInstrumentById(Integer id) {
        Instrument instrument = getInstrumentByIdIfExists(id);
        return instrumentDtoMapper.toFullDto(instrument);
    }
    @Transactional
    public FullInstrumentDto createInstrument(CreateUpdateInstrumentDto createUpdateInstrumentDto) {
        Instrument instrument = instrumentDtoMapper.toEntity(createUpdateInstrumentDto);
        Instrument savedInstrument = instrumentRepository.save(instrument);
        return instrumentDtoMapper.toFullDto(savedInstrument);
    }
    @Transactional
    public FullInstrumentDto updateInstrumentById(int id, CreateUpdateInstrumentDto createUpdateInstrumentDto) {
        Instrument instrument = getInstrumentByIdIfExists(id);

        instrumentDtoMapper.partialUpdate(createUpdateInstrumentDto, instrument);

        Instrument updatedInstrument = instrumentRepository.save(instrument);
        return instrumentDtoMapper.toFullDto(updatedInstrument);
    }
    @Transactional
    public void deleteInstrumentById(int id) {
        Instrument instrument = getInstrumentByIdIfExists(id);

        instrumentRepository.delete(instrument);
    }

    private Instrument getInstrumentByIdIfExists(int id) {
        return instrumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instrument not found with id: " + id));
    }
}
