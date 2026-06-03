package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@DisplayName(value = "Owner SD Jpa Service Test")
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
      //  service = new OwnerSDJpaService(null, null, null);

    }

    @Disabled
    @Test
    void findByLastName() {
        Owner foundOwner = service.findByLastName("Buck");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        // GIVEN
        Long ownerId = 1L;
        Owner owner = new Owner(ownerId,"John","Doe");

        // TODO 3 : Écrivez la ligne Mockito pour dire :
        // "Quand ownerRepository.findById est appelé avec ownerId, renvoyez cet owner (emballé dans un Optional)"
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.of(owner));

        // WHEN
        Owner foundOwner = service.findById(ownerId);

        verify(ownerRepository).findById(ownerId);

        // THEN
        assertNotNull(foundOwner);
        assertEquals("John", foundOwner.getFirstName());
        assertEquals("Doe", foundOwner.getLastName());
    }

    @Test
    void findByIdNotFound() {
        // GIVEN
        Long ownerId = 1L;

        // TODO 3 : Écrivez la ligne Mockito pour dire :
        // "Quand ownerRepository.findById est appelé avec ownerId, renvoyez cet owner (emballé dans un Optional)"
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.empty());

        // WHEN
        Owner foundOwner = service.findById(ownerId);

        verify(ownerRepository).findById(ownerId);

        // THEN
        assertNull(foundOwner);
    }

    @Test
    void save() {
        Owner owner = new Owner(1L,"John","Doe");

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = service.save(owner);

        verify(ownerRepository).save(owner);

        assertNotNull(savedOwner);
        assertEquals("John", savedOwner.getFirstName());
        assertEquals("Doe", savedOwner.getLastName());
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}