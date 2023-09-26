package org.nonit.mamnon.service;


import org.nonit.mamnon.dao.DanhMucChiMamNonDAO;
import org.nonit.mamnon.entity.thuchimamnon.DanhMucChiMamNon;
import org.nonit.mamnon.mapper.DanhMucChiMamNonMapper;
import org.nonit.mamnon.service.model.DanhMucChiMamNonDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class DanhMucChiMamNonService {

    @Inject
     DanhMucChiMamNonDAO danhMucChiMamNonDAO;

    @Inject
     DanhMucChiMamNonMapper danhMucChiMamNonMapper;

    public List<DanhMucChiMamNonDTO> findAll() {
        List<DanhMucChiMamNon> danhMucChiMamNonList = danhMucChiMamNonDAO.findAll();
        return danhMucChiMamNonMapper.toDTOList(danhMucChiMamNonList);
    }
}

