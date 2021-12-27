package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Article;

/**
 * Interface qui définit les méthodes obligatoires du CRUD pour le table Article.
 * 
 * @author Christian Ingold
 *
 */
public interface ArticleDao {
	List<Article> extraire() throws SQLException;

	Article creer(Article article) throws SQLException;

	int update(Article article) throws SQLException;

	boolean delete(Article article) throws SQLException;

	Article findOne(String ref) throws SQLException;

}
