package com.rafaelamaral.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.rafaelamaral.model.People;
import com.rafaelamaral.repository.connection.SingleConnectionDataBase;

public class DAOPeopleRepository {

	private Connection connection;

	public DAOPeopleRepository() {
		connection = SingleConnectionDataBase.getConnection();
	}

	public ArrayList<People> listAll() {

		ArrayList<People> list = new ArrayList<People>();

		try {

			String sql = "SELECT * FROM tb_people";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);

				list.add(new People(id ,  name , email));
			}
			
			preparedStatement.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void save(People people) {
		try {
			String sql = "INSERT INTO tb_people(name,email) values(? , ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, people.getName());
			preparedStatement.setString(2, people.getEmail());

			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remove(Long id) {
		try {
			String sql = "DELETE FROM tb_people WHERE id=(?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(People people) {
		try {
			String sql = "UPDATE tb_people set name=? email=?  WHERE id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,people.getName());
			preparedStatement.setString(2,people.getEmail());
			preparedStatement.setLong(3, people.getId());


			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
