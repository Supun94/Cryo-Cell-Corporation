/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation;

import controller.CustomerController;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author supun-pc
 */
public class CustomerReserver {
    private Map<String,CustomerController> reserveData=new HashMap<String,CustomerController>();
    
    public boolean reserveCustomer(String id,CustomerController customerController){
        if(reserveData.containsKey(id)){
            if(reserveData.get(id)==customerController){
                return true;
            }else{
                return false;
            }
        }else{
            reserveData.put(id, customerController);
            return true;
        }
    }
    public boolean releaseCustomer(String id, CustomerController customerController){
        if(reserveData.get(id)==customerController){
            reserveData.remove(id);
            return true;
        }else{
            return false;
        }
    }
}
