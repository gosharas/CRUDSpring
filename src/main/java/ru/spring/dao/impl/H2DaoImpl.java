package ru.spring.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.spring.dao.interfaces.ContactsDao;
import ru.spring.dao.objects.Contacts;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class H2DaoImpl  implements ContactsDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create() {

    }

    @Override
    public Contacts getContactsByID(int id) {
        String sql = "select * from contacts where id=:id";

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, param, new ContactsRowMapper());
    }

    @Override
    public void insert(Contacts contacts) {
        String sql = "insert into contacts (name, author) VALUES(?, ?)";

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", contacts.getName());
        param.addValue("author", contacts.getAuthor());

        jdbcTemplate.update(sql, param);

    }

    @Override
    public void delete(Contacts contacts) {
        String sql = "delete from contacts where id=:id";

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", contacts.getId());

        jdbcTemplate.update(sql, param);

    }

    @Override
    public void deleteTable() {

    }

    @Override
    public List<Contacts> getContactsListAll() {

        return null;
    }

    private static final class ContactsRowMapper implements RowMapper<Contacts>{
        @Override
        public Contacts mapRow(ResultSet resultSet, int i) throws SQLException {
            Contacts contacts = new Contacts();
            contacts.setId(resultSet.getInt("id"));
            contacts.setName(resultSet.getString("name"));
            contacts.setAuthor(resultSet.getString("author"));
            return contacts;
        }
    }
}

