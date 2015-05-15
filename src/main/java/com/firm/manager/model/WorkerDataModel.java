package com.firm.manager.model;

import com.firm.manager.dao.entity.Worker;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SelectableDataModel;

public class WorkerDataModel extends LazyDataModel<Worker> implements SelectableDataModel<Worker> {
//    @Inject
//    private StorageManager storageManager;
//
//    @Override
//    public Object getRowKey(Worker worker) {
//        return worker.getId();
//    }
//
//    @Override
//    public Worker getRowData(String s) {
//        return storageManager.find(Worker.class, new Long(s));
//    }
}
