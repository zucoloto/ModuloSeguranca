package br.mil.eb.ccomsex.seg.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.mil.eb.ccomsex.seg.model.entity.Grupo;
import br.mil.eb.ccomsex.seg.model.service.GrupoService;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

	@Inject
	private GrupoService grupoService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Grupo retorno = null;
		if (StringUtils.isNotEmpty(value)) {
			retorno = this.grupoService.buscarPorId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			return ((Grupo) value).getId().toString();
		}
		return "";
	}

}
