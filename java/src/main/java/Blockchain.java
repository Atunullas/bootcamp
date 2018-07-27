import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Blockchain {
	private List<Block> blockchain = new ArrayList<Block>();

	public void add_blocks(Block blk) {
		this.blockchain.add(blk);
	}

	public Block get_latest_block() {
		return (Block) this.blockchain.get(blockchain.size() - 1);
	}

	public boolean validateChain() {
		// return false;

		// TODO implement this,
		/*
		 * 1. Iterate over all blocks and validate() 2. Check if the prev_hash of
		 * current block is same as the hash of previous block block.prev_hash ==
		 * previous_block.hash
		 */
		String previousHash = null;
		for (Block b : this.blockchain) {

			if (!b.validate() && b.getPrev_hash() != null && 
					!b.getPrev_hash().equals(previousHash)) {
				return false;
			}
			previousHash = b.getHash();
		}

		return true;

	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public static Blockchain blockchainFromJson(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Blockchain.class);
	}

	public static Blockchain blockchainFromJson(BufferedReader json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Blockchain.class);
	}

	public void saveAsJson() {
		try {
			FileWriter writer = new FileWriter("blockchain.json");
			writer.write(this.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Blockchain loadFromJson() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("blockchain.json"));
			return blockchainFromJson(br);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
