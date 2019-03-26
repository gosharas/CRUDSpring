package ru.spring.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.dao.interfaces.ContactsDao;
import ru.spring.dao.objects.Contacts;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class H2DaoImpl  implements ContactsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Contacts getContactsByID(int id) {
        String sql = "select id, name, author from contacts where id = ?";
        RowMapper<Contacts> rowMapper = new BeanPropertyRowMapper<Contacts>(Contacts.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void insert(Contacts contacts) {
        String sql = "INSERT INTO contacts (id, name, author) values (?, ?, ?)";
        jdbcTemplate.update(sql, contacts.getId(), contacts.getName(), contacts.getAuthor());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from contacts where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Contacts> getContactsListAll() {
        String sql = "SELECT id, name, author FROM contacts";
        RowMapper<Contacts> rowMapper = new BeanPropertyRowMapper<Contacts>(Contacts.class);
        return this.jdbcTemplate.query(sql, rowMapper);

    }

    public static final class ContactsRowMapper implements RowMapper<Contacts> {
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

