package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.FlatUserDto;
import com.kachinsky.musifindmebackend.entity.User;
import com.kachinsky.musifindmebackend.dto.FullUserDto;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.WARN,
        componentModel = MappingConstants.ComponentModel.SPRING
//        uses = {ArtistDtoMapper.class, InstrumentDtoMapper.class, GenreDtoMapper.class, ReleaseDtoMapper.class, SongDtoMapper.class}
)
public interface UserDtoMapper {
//    @Mapping(source = "socials", target = "socialsJson")
//    User toUser(FullUserDto fullUserDto);
//
//    @Mapping(source = "socialsJson", target = "socials")
//    FullUserDto toFullUserDto(User user);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "socials", target = "socialsJson")
//    User partialUpdate(FullUserDto fullUserDto, @MappingTarget User user);

    @Mapping(source = "socials", target = "socialsJson")
    User toUser(FlatUserDto flatUserDto);

    @Mapping(source = "socialsJson", target = "socials")
    FlatUserDto toFlatUserDto(User user);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    User partialUpdate(FlatUserDto flatUserDto, @MappingTarget User user);
}