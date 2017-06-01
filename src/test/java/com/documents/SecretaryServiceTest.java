package com.documents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.documents.models.Secretary;
import com.documents.repositories.SecretaryRepository;
import com.documents.services.SecretaryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SecretaryServiceTest {

    //Arrange
    @Mock
    private SecretaryRepository secretaryRepository;

    @InjectMocks
    private SecretaryServiceImpl secretaryServiceImpl = new SecretaryServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }


    public void setup(Secretary secretaryToSet) {

        secretaryToSet.setId((long) 3);
        secretaryToSet.setFirstName("Maria");
        secretaryToSet.setLastName("Popescu");
        secretaryToSet.setPassword("euSuntMariaPopescu");
        secretaryToSet.setWebmail("maria.popescu@webmail.ro");

    }

    @Test
    public void behavioural_secretary_save_should_return_true() throws Exception {

        //Act
        Secretary secretaryAfterSave = new Secretary();
        Secretary secretaryToSave = new Secretary();

        setup(secretaryToSave);

        when(secretaryRepository.save(any(Secretary.class))).thenReturn(secretaryAfterSave);

        secretaryAfterSave = secretaryServiceImpl.save(secretaryToSave);

        //Assert
        assertNotNull(secretaryAfterSave);
    }

    @Test
    public void functionality_secretary_save_should_return_secretary() throws Exception {

        //Act
        Secretary secretaryAfterSave = new Secretary();

        setup(secretaryAfterSave);

        when(secretaryRepository.save(any(Secretary.class))).thenReturn(secretaryAfterSave);

        Secretary savedSecretary = secretaryServiceImpl.save(secretaryAfterSave);

        //Assert
        assertEquals(Long.valueOf(3), savedSecretary.getId());
        assertEquals("Maria", savedSecretary.getFirstName());
        assertEquals("Popescu", savedSecretary.getLastName());
        assertEquals("euSuntMariaPopescu", savedSecretary.getPassword());
        assertEquals("maria.popescu@webmail.ro", savedSecretary.getWebmail());

    }

    @Test
    public void behavioural_secretary_findById_should_return_true() throws Exception {

        //Act
        Secretary secretaryToFind = new Secretary();

        when(secretaryRepository.findOne(any(long.class))).thenReturn(secretaryToFind);

        secretaryToFind = secretaryServiceImpl.findById((long) 123);

        //Assert
        assertNotNull(secretaryToFind);
    }

    @Test
    public void functionality_secretary_findById_should_return_secretary() throws Exception {

        //Act
        Secretary secretaryToFind = new Secretary();

        setup(secretaryToFind);

        when(secretaryRepository.findOne(any(long.class))).thenReturn(secretaryToFind);

        Secretary findedSecretary = secretaryServiceImpl.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), findedSecretary.getId());
        assertEquals("Maria", findedSecretary.getFirstName());
        assertEquals("Popescu", findedSecretary.getLastName());
        assertEquals("euSuntMariaPopescu", findedSecretary.getPassword());
        assertEquals("maria.popescu@webmail.ro", findedSecretary.getWebmail());

    }

    @Test
    public void behavioural_secretary_deleteById_should_return_true() throws Exception {

        //Act
        Secretary secretary = new Secretary();

        secretary.setId((long) 3);

        secretaryServiceImpl.delete(secretary.getId());

        Secretary findedSecretary = secretaryServiceImpl.findById((long) 3);

        //Assert
        assertNull(findedSecretary);

    }


    @Test
    public void functionality_secretary_deleteById_should_return_delete_secretary() throws Exception {

        //Act
        Secretary secretary = new Secretary();

        secretaryServiceImpl.delete(secretary.getId());

        //Assert
        verify(secretaryRepository).delete(secretary.getId());

    }

    @Test
    public void behavioural_secretary_findAll_should_return_true() throws Exception {

        //Act
        List<Secretary> secretaries = new ArrayList<>();

        Secretary secretary = new Secretary();

        setup(secretary);

        when(secretaryRepository.findAll()).thenReturn(secretaries);

        secretaries.add(secretary);

        List<Secretary> findedSecretaries;
        findedSecretaries = secretaryServiceImpl.findAll();

        //Assert
        assertNotNull(findedSecretaries);

    }

    @Test
    public void functionality_secretary_findAll_should_return_list_of_secretary() throws Exception {

        //Act
        List<Secretary> secretaries = new ArrayList<>();

       Secretary secretary = new Secretary();

        setup(secretary);

        when(secretaryRepository.findAll()).thenReturn(secretaries);

        secretaries.add(secretary);

        List<Secretary> findedSecretaries;
        findedSecretaries = secretaryServiceImpl.findAll();

        //Assert
        assertEquals(secretaries.get(0).getId(), findedSecretaries.get(0).getId());
        assertEquals(secretaries.get(0).getFirstName(), findedSecretaries.get(0).getFirstName());
        assertEquals(secretaries.get(0).getLastName(), findedSecretaries.get(0).getLastName());
        assertEquals(secretaries.get(0).getPassword(), findedSecretaries.get(0).getPassword());
        assertEquals(secretaries.get(0).getWebmail(), findedSecretaries.get(0).getWebmail());

    }
}
