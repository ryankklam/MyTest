package testing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MapStructTest {


    @Test
    public void One2OneMappingTest(){

        CustomerVO customerVO = new CustomerVO();
        customerVO.setDateOfIncooperation(19851226);
        customerVO.setCustShortName("Ryan");
        customerVO.setTerm("999M");

        CustomerDTO customerDTO = CustomerConvertor.INSTANCE.toConvertToDTO(customerVO);

        //如果field名称属性相同 自动可以map
        Assert.assertEquals(customerVO.getDateOfIncooperation(),customerDTO.getDateOfIncooperation());

        //如果field名称不同 指定注解可以map
        Assert.assertEquals(customerVO.getCustShortName(),customerDTO.getCustName());

        Assert.assertEquals("999",customerVO.getTerm().substring(0,3));
        Assert.assertEquals("M",customerVO.getTerm().substring(3,4));

        //如果类型也不同，可自定义表达式方法去map
        Assert.assertEquals(customerVO.getTerm().substring(0,3),customerDTO.getPeriod().getUnit());
        Assert.assertEquals(customerVO.getTerm().substring(3,4),customerDTO.getPeriod().getCycle());

    }

    @Test
    public void all2OneMappingTest(){

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfIncooperation(19860130);
        customerDTO.setCustName("Vita");
        customerDTO.setPeriod(new Period("888","Y"));

        CustomerVO customerVO = CustomerConvertor.INSTANCE.toConvertToVO(customerDTO);

        //如果field名称属性相同 自动可以map
        Assert.assertEquals(customerDTO.getDateOfIncooperation(),customerVO.getDateOfIncooperation());

        //如果field名称不同 指定注解可以map
        Assert.assertEquals(customerDTO.getCustName(),customerVO.getCustShortName());


        //如果类型也不同，可自定义表达式方法去map
//        Assert.assertEquals(customerVO.getTerm().substring(0,3),customerDTO.getPeriod().getUnit());
        Assert.assertEquals(customerDTO.getPeriod().getCycle(),customerVO.getTerm());

    }


}
