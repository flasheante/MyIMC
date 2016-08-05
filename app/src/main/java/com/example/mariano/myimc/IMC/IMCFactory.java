package com.example.mariano.myimc.IMC;

import android.content.Context;

import com.example.mariano.myimc.database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mariano on 3/8/16.
 */
public class IMCFactory {

    private static IMCFactory instance;
    private Dao<IMC, Integer> imcDao;

    private IMCFactory(Context context) {
        OrmLiteSqliteOpenHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);

        try {
            imcDao = helper.getDao(IMC.class);
        } catch (SQLException e) {
            // Boo hoo
        }
    }

    public static IMCFactory getInstance(Context context) {
        if (instance == null) {
            instance = new IMCFactory(context);
        }

        return instance;
    }

    public List<IMC> getIMCList() throws SQLException {
        return imcDao.queryForAll();
    }

    public boolean addIMC(IMC newItem) {
        try {
            imcDao.create(newItem);
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public boolean removeIMC(IMC toDelete) {
        try {
            imcDao.delete(toDelete);
        } catch (SQLException e) {
            return false;
        }

        return true;
    }
}
