/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Excepciones.ConnectException;
import Excepciones.HealthCardException;
import Excepciones.NotValidePrescriptionException;
import Excepciones.ProductIDException;
import Pharmacy.Dispensing;
import Pharmacy.ProductSpecification;
import java.util.List;

/**
 *
 * @author mfoulouyvesmarcel
 */
public interface NationalHealthService {
    Dispensing getePrescription(HealthCardID hcID)
throws HealthCardException, NotValidePrescriptionException,
               ConnectException;
PatientContr getPatientContr(HealthCardID hcID) throws ConnectException;
ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException;
List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException;


}
