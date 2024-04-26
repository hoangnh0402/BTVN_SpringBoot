package com.example.btvn_week6.converter;

import com.example.btvn_week6.dto.AccountDTO;
import com.example.btvn_week6.entity.AccountEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountConverter {
    private ModelMapper modelMapper = new ModelMapper() ;

    public AccountDTO convertToDto (AccountEntity entity){
        AccountDTO result = modelMapper.map(entity, AccountDTO.class);
        return result;
    }

    public AccountEntity convertToEntity (AccountDTO dto){
        AccountEntity result = modelMapper.map(dto, AccountEntity.class);
        return result;
    }

    public List<AccountDTO> convertToListDto (List<AccountEntity> entities){
        List<AccountDTO> userDTOS = new ArrayList<>();
        for (AccountEntity userEntity : entities){
            AccountDTO result = modelMapper.map(userEntity, AccountDTO.class);
            userDTOS.add(result);
        }
        return userDTOS;
    }

    public List<AccountEntity> convertToListEntity (List<AccountDTO> dtos){
        List<AccountEntity> userEntities = new ArrayList<>();
        for (AccountDTO userDTO : dtos){
            AccountEntity result = modelMapper.map(userDTO, AccountEntity.class);
            userEntities.add(result);
        }
        return userEntities;
    }
}
