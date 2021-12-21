package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Article;

public interface ArticleDao {
	List<Article> extraire() throws SQLException;
	void creer(Article article) throws SQLException;
	int update(Article article) throws SQLException;
	boolean delete(Article article) throws SQLException;
	Article findOne(String ref) throws SQLException;
	
}


