package com.documents.services;

import java.io.IOException;
import java.util.List;

import com.documents.models.WithdrawalDocumentRequest;
import com.itextpdf.text.DocumentException;

/**
 * Created by Cami on 2017-05-11.
 */
public interface WithdrawalDocumentRequestService extends CrudService<WithdrawalDocumentRequest>{

    void createPdf(List<String> list, String filePath) throws IOException, DocumentException;

    WithdrawalDocumentRequest getStudentListByWithdrawalDocumnet(Long id);
}
