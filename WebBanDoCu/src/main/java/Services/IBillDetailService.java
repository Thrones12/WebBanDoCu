package Services;

import java.util.List;

import Models.BillDetail;

public interface IBillDetailService {

	 List<BillDetail> findAll();
	    
	 void insert(BillDetail billDetail);
	    
	 void update(BillDetail billDetail);
	    
	 void delete(int billDetail_id);
	    
	 BillDetail findById(int billDetail_id);
}
