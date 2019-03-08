package com.example.lenovo.playandroid.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.lenovo.playandroid.dao.HistoryData;
import com.example.lenovo.playandroid.dao.LogDaoBean;
import com.example.lenovo.playandroid.dao.CanData;
import com.example.lenovo.playandroid.dao.ShanData;

import com.example.lenovo.playandroid.dao.HistoryDataDao;
import com.example.lenovo.playandroid.dao.LogDaoBeanDao;
import com.example.lenovo.playandroid.dao.CanDataDao;
import com.example.lenovo.playandroid.dao.ShanDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig historyDataDaoConfig;
    private final DaoConfig logDaoBeanDaoConfig;
    private final DaoConfig canDataDaoConfig;
    private final DaoConfig shanDataDaoConfig;

    private final HistoryDataDao historyDataDao;
    private final LogDaoBeanDao logDaoBeanDao;
    private final CanDataDao canDataDao;
    private final ShanDataDao shanDataDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        historyDataDaoConfig = daoConfigMap.get(HistoryDataDao.class).clone();
        historyDataDaoConfig.initIdentityScope(type);

        logDaoBeanDaoConfig = daoConfigMap.get(LogDaoBeanDao.class).clone();
        logDaoBeanDaoConfig.initIdentityScope(type);

        canDataDaoConfig = daoConfigMap.get(CanDataDao.class).clone();
        canDataDaoConfig.initIdentityScope(type);

        shanDataDaoConfig = daoConfigMap.get(ShanDataDao.class).clone();
        shanDataDaoConfig.initIdentityScope(type);

        historyDataDao = new HistoryDataDao(historyDataDaoConfig, this);
        logDaoBeanDao = new LogDaoBeanDao(logDaoBeanDaoConfig, this);
        canDataDao = new CanDataDao(canDataDaoConfig, this);
        shanDataDao = new ShanDataDao(shanDataDaoConfig, this);

        registerDao(HistoryData.class, historyDataDao);
        registerDao(LogDaoBean.class, logDaoBeanDao);
        registerDao(CanData.class, canDataDao);
        registerDao(ShanData.class, shanDataDao);
    }
    
    public void clear() {
        historyDataDaoConfig.clearIdentityScope();
        logDaoBeanDaoConfig.clearIdentityScope();
        canDataDaoConfig.clearIdentityScope();
        shanDataDaoConfig.clearIdentityScope();
    }

    public HistoryDataDao getHistoryDataDao() {
        return historyDataDao;
    }

    public LogDaoBeanDao getLogDaoBeanDao() {
        return logDaoBeanDao;
    }

    public CanDataDao getCanDataDao() {
        return canDataDao;
    }

    public ShanDataDao getShanDataDao() {
        return shanDataDao;
    }

}
