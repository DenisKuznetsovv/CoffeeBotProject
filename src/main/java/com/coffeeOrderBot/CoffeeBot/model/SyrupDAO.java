package com.coffeeOrderBot.CoffeeBot.model;

import java.sql.SQLException;
import java.util.List;

public interface SyrupDAO {
    void addSyrup(Syrup syrup) throws SQLException;
    void updateSyrup(Long id, Syrup syrup) throws SQLException;
    List<Syrup> getDistinctByName() throws SQLException;
}
