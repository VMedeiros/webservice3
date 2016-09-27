package aplicacao.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

		@RequestMapping(value="/usuario", method = RequestMethod.GET)
		public ResponseEntity< List<Usuario> > listaDeUsuario() {
			
			List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
			listaDeUsuarios.add(new Usuario(1,"Victor","123"));
			listaDeUsuarios.add(new Usuario(2,"Bob","321"));
			
			return new ResponseEntity< List<Usuario> >(listaDeUsuarios, HttpStatus.OK);
		}

		@RequestMapping(value = "/usuario/{id}",method = RequestMethod.GET)
		public ResponseEntity<Usuario> informacaoUsuario(@PathVariable String id) {
			
			Usuario Usuario = new Usuario(1,"Victor","123");
			
			return Usuario == null ? 
					new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND) : 
						new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/usuario/{id}",method = RequestMethod.DELETE)
		public ResponseEntity<Usuario> removerUsuario(@PathVariable String id) {
			
			Usuario Usuario = new Usuario(1,"Victor","123");
			
			return Usuario == null ? 
					new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND) : 
						new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);
		}
		
		@RequestMapping(value="/usuario", method = RequestMethod.POST)
		public ResponseEntity<String> novoUsuario(@RequestBody Usuario usuario) {

			try {
				return new ResponseEntity<String>(HttpStatus.CREATED);

			} catch (Exception e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@RequestMapping(value="/usuario", method = RequestMethod.PUT)
		public ResponseEntity<String> alterarUsuario(@RequestBody Usuario usuario) {

			try {
				return new ResponseEntity<String>(HttpStatus.CREATED);

			} catch (Exception e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
