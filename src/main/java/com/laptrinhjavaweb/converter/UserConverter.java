package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }

    public List<UserEntity> convertToEntityFromResultSet(ResultSet resultSet){
        List<UserEntity> result = new ArrayList<>();
        try{
            while (resultSet.next()){
                UserEntity entity = new UserEntity();
                entity.setEmail(resultSet.getString("email"));
                entity.setUserName(resultSet.getString("username"));
                entity.setFullName(resultSet.getString("fullname"));
                entity.setPassword(resultSet.getString("password"));
                entity.setStatus(resultSet.getInt("status"));
                entity.setId(resultSet.getLong("id"));
                entity.setCreatedDate(resultSet.getDate("createddate"));
                entity.setCreatedBy(resultSet.getString("createdby"));
                entity.setModifiedBy(resultSet.getString("modifiedby"));
                entity.setModifiedDate(resultSet.getDate("modifieddate"));
                result.add(entity);
            }
            return result;

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
