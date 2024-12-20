package org.yearup.data.mysql;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        // get all categories
        List<Category> allCategories = new ArrayList<>();
        String sql = """
                SELECT *
                FROM Categories
                """;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allCategories.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allCategories;
    }

    @Override
    public Category getById(int categoryId) {
        // get category by id
        String sql = """
                SELECT *
                FROM Categories
                WHERE category_id = ?
                """;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Category create(Category category) {
        // create a new category
        String sql = """
                INSERT INTO categories
                (name, description)
                VALUES
                (?, ?)
                """;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            int rowsAffected = preparedStatement.executeUpdate();
            // Is there another way to do this?
            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // check that category id was generated, and get it
                    int categoryId = generatedKeys.getInt(1);
                    return getById(categoryId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(int categoryId, Category category) {
        // update category
        String sql = """
                UPDATE categories
                SET name = ?,
                description = ?
                WHERE categoryId = ?
                """;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            // Why are we passing it in?
            preparedStatement.setInt(3, categoryId);
            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int categoryId) {
        // Why is categoryId separate? Why not build into Category?
        // delete category
        String sql = """
                DELETE FROM categories
                WHERE categoryId = ?
                """;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Category mapRow(ResultSet row) throws SQLException {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category() {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
