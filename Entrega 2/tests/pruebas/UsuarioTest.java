package usuarios;

import learningPaths.Actividad;

public class UsuarioTest {
	
	private Usuario usuario;
	private Actividad act1;
	
	@BeforeEach
    public void setUp() {
		usuario = new Usuario("contrasenia", "nicolas", "hernandez", "login");
		act1 = new Actividad("Aprender EDA","EDA Act", "Medio", act_prerrequisito, act_sugerida, "Muy buena", 5, 3.2, false);
	}
	
	@AfterEach
    public void tearDown() 
	{
    }
	
	@Test
	public void testGetNombre() {
        assertEquals("nicolas", usuario.getNombre(), "El nombre no es correcto");
    }
	
	@Test
	public void testGetApellido() {
        assertEquals("hernandez", usuario.getApellido(), "El apellido no es correcto");
    }
	
	@Test
	public void testGetLogin() {
        assertEquals("login", usuario.getLogin(), "El login no es correcto");
    }
	
	@Test
	public void testGetContrasenia() {
        assertEquals("contrasenia", usuario.getContrasenia(), "La contrasenia no es correcta");
    }
	
	@Test
	public void testReseniar() {
		usuario.reseniar(" resenia", act1);
        assertEquals("Muy buena" + " resenia", act1.getResenias(), "No se resenio correctamente");
    }
	
	@Test
	public void testRatear() {
		act1.ratear(3.5);
		assertEquals(3.35, act1.getRating(), "El rating de la actividad no es correcto");
	}
	
	@Test
	public void testGetAuth() {
		assertTrue("La contrasenia o el login no es correcto", usuario.getAuth("login", "contrasenia"));
	}
}
