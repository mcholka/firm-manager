package com.firm.manager.controller;

import com.firm.manager.FacesUtil;
import com.firm.manager.dao.control.StorageManager;
import com.firm.manager.dao.control.WorkerManager;
import com.firm.manager.dao.entity.Position;
import com.firm.manager.dao.entity.Worker;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ManagedBean
@ViewScoped
public class AddWorkerController {
    private static final Logger logger = Logger.getLogger(AddWorkerController.class);

    @Inject
    private StorageManager storageManager;
    @Inject
    private FacesUtil facesUtil;
    @Inject
    private WorkerManager workerManager;

    private Worker newWorker;

    @PostConstruct
    public void init() {
        logger.info("Prepare to add new worker");
        newWorker = new Worker();
    }

    public void persist() throws IOException {
        logger.info("Check worker already exist");
        if (newWorker.getPersonalData() != null) {
            Optional<Worker> workerOptional = workerManager.findBy(newWorker.getPersonalData());
            if(workerOptional.isPresent()) {
                facesUtil.putErrorMessage("Pracownik o danych: " + newWorker.getPersonalData() + " juz istnieje!");
                logger.error("Worker with personal data: " + newWorker.getPersonalData() + " already exist!");
                return;
            }
            logger.info("Ok, no worker with data: " + newWorker.getPersonalData());
        }
        storageManager.persist(newWorker);
        facesUtil.putInfoMessage("Uzytkownik " + newWorker.getPersonalData() + " zostal zapisany poprawnie :)");
        facesUtil.externalContext().redirect("/FirmManager/admin/worker/index.xhtml");
        logger.info("User persisted");
    }

    public List<SelectItem> getAllPositions() {
        logger.info("Get all positions");
        List<SelectItem> selectItems = new ArrayList<>();
        for (Position position : Position.values()) {
            selectItems.add(new SelectItem(position, position.getViewName()));
        }
        return selectItems;
    }

    public String getMaxDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public Worker getNewWorker() {
        return newWorker;
    }

    public void setNewWorker(Worker newWorker) {
        this.newWorker = newWorker;
    }
}
