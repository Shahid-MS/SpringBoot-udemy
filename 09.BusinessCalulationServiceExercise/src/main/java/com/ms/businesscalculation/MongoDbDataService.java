package com.ms.businesscalculation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mongo qualifier")
public class MongoDbDataService implements DataService {
    public int[] retrieveData(){
        return new int[] {1,3,5,6,3,2,1};
    }
}
