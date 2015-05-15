package com.firm.manager.controller;

import com.firm.manager.FacesUtil;
import com.firm.manager.dao.control.StorageManager;
import com.firm.manager.dao.control.WorkerManager;
import com.firm.manager.dao.entity.Worker;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class EditWorkerController implements Serializable {
    private static final Logger logger = Logger.getLogger(EditWorkerController.class);

    @Inject
    private FacesUtil facesUtil;
    @Inject
    private StorageManager storageManager;
    @Inject
    private WorkerManager workerManager;

    private Worker selectedWorker;
    private List<Worker> workers;

    @PostConstruct
    public void init() {
        logger.info("Prepare to edit worker");
        workers = workerManager.findNotDeleted();
    }

    public void edit() {
        selectedWorker.setLastModified(new Date());
        facesUtil.putInfoMessage("U¿ytkownik " + selectedWorker.getPersonalData() + " zosta³ edytowany");
        logger.info("User: " + selectedWorker.getId() + " edited!");
    }

    public void delete() {
        selectedWorker.setDeleted(true);
        facesUtil.putInfoMessage("U¿ytkownik " + selectedWorker.getPersonalData() + " zosta³ usuniêty");
        logger.info("User: " + selectedWorker.getId() + " deleted!");
    }

    public Integer getWorkersSize() {
        return workers.size();
    }

    public Worker getSelectedWorker() {
        return selectedWorker;
    }

    public void setSelectedWorker(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
