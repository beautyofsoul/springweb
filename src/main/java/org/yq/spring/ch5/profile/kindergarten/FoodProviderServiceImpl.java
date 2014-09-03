package org.yq.spring.ch5.profile.kindergarten;

import java.util.ArrayList;
import java.util.List;

import org.yq.spring.ch5.profile.Food;
import org.yq.spring.ch5.profile.FoodProviderService;

public class FoodProviderServiceImpl implements FoodProviderService {

	@Override
	public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<Food>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));
		return lunchSet;
	}

}
