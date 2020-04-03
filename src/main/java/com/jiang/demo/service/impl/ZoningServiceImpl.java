package com.jiang.demo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.jiang.demo.entity.SysZoningTable;
import com.jiang.demo.service.ZoningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Slf4j
@Service
public class ZoningServiceImpl implements ZoningService {
    @Override
    public List<SysZoningTable> buildTree(List<SysZoningTable> zonings) {
        List<SysZoningTable> returnList = new ArrayList<SysZoningTable>();
        List<Long> tempList = new ArrayList<Long>();
        for (SysZoningTable zoning : zonings)
        {
            tempList.add(zoning.getId());
        }
        for (Iterator<SysZoningTable> iterator = zonings.iterator(); iterator.hasNext();)
        {
            SysZoningTable zoning = (SysZoningTable) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(zoning.getPid()))
            {
                recursionFn(zonings, zoning);
                returnList.add(zoning);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = zonings;
        }

        return returnList;
    }

    private void recursionFn(List<SysZoningTable> list, SysZoningTable t)
    {
        // 得到子节点列表
        List<SysZoningTable> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysZoningTable tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<SysZoningTable> it = childList.iterator();
                while (it.hasNext())
                {
                    SysZoningTable n = (SysZoningTable) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    private List<SysZoningTable> getChildList(List<SysZoningTable> list, SysZoningTable t)
    {
        List<SysZoningTable> tlist = new ArrayList<SysZoningTable>();
        Iterator<SysZoningTable> it = list.iterator();
        while (it.hasNext())
        {
            SysZoningTable n = (SysZoningTable) it.next();
            if (null != n.getPid() && n.getPid().equals(t.getId()))
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysZoningTable> list, SysZoningTable t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
