import com.google.gson.Gson;

public class BlockHeader {
	private String payload_hash;
	private String timestamp;
	private String prev_hash;
	private String total_transaction_count;

	public String getPayload_hash() {
		return payload_hash;
	}

	public void setPayload_hash(String payload_hash) {
		this.payload_hash = payload_hash;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPrev_hash() {
		return prev_hash;
	}

	public void setPrev_hash(String prev_hash) {
		this.prev_hash = prev_hash;
	}

	public String getTotal_transaction_count() {
		return total_transaction_count;
	}

	public void setTotal_transaction_count(String total_transaction_count) {
		this.total_transaction_count = total_transaction_count;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}