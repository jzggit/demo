package com.jiang.demo.service;

import com.jiang.demo.entity.SysZoningTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZoningService {
    public List<SysZoningTable> buildTree(List<SysZoningTable> zonings);
}
