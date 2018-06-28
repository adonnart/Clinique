package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.ClientDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOFactory;

public class ClientManager {
	private ClientDAO clientDao = DAOFactory.getClientDAO();
	private static ClientManager clientManager;

	public ClientManager() {
	}

	public static synchronized ClientManager getInstance() throws BLLException {
		if (clientManager == null) {
			clientManager = new ClientManager();
		}
		return clientManager;
	}

	public void addClient(Client client) throws BLLException {
		try {
			clientDao.insert(client);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void updateClient(Client client) throws BLLException {
		try {
			clientDao.update(client);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void selectClient(int codeclient) throws BLLException {
		try {
			clientDao.selectById(codeclient);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void removeClient(Client client, int index) throws BLLException {
		try {
			if (index < 0) {
				throw new BLLException("'id' ne doit pas être à 0");
			}
			clientDao.delete(client);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}
	public List<Client> getAllClient() throws BLLException{

		try {
			return clientDao.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

}
