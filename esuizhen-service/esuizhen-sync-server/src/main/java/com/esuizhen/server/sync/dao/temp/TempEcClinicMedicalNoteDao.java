package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.ClinicMedicalNoteRes;
import com.esuizhen.server.sync.model.temp.SyncEcClinicMedicalNote;

public interface TempEcClinicMedicalNoteDao {

	void insert(SyncEcClinicMedicalNote ecClinicMedicalNote);

    List<ClinicMedicalNoteRes> getSyncClinicMedicalNote(TBatchDetailInfo detail);
}
