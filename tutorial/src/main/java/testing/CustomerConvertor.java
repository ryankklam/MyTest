package testing;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerConvertor {

    CustomerConvertor INSTANCE = Mappers.getMapper(CustomerConvertor.class);

    @Mapping(source = "custShortName" , target = "custName")
    @Mapping(target = "period", expression = "java( new testing.Period(customerVO.getTerm().substring(0,3),customerVO.getTerm().substring(3,4)) )")
    CustomerDTO toConvertToDTO(CustomerVO customerVO);

    @Mapping(source = "custName" , target = "custShortName")
    @Mapping(target = "term" , source = "period.cycle")
    CustomerVO toConvertToVO(CustomerDTO customerDTO);

}
