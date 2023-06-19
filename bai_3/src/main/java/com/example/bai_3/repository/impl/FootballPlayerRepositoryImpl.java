package com.example.bai_3.repository.impl;

import com.example.bai_3.model.FootballPlayer;
import com.example.bai_3.repository.IFootballPlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FootballPlayerRepositoryImpl implements IFootballPlayerRepository {
    private static final List<FootballPlayer> playerList = new ArrayList<>();

    static {
        playerList.add(new FootballPlayer(1, "Alphonso Davies", "19-11-2001", "2 năm", "Hậu vệ", "https://img.fcbayern.com/image/upload/t_cms-1x1-seo/v1656615722/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/alphonso_davies.png"));
        playerList.add(new FootballPlayer(2, "Ruben Dias", "19-11-2001", "2 năm", "Trung vệ", "https://sportx.vn/wp-content/uploads/2023/06/ruben_dias_2022_22453151bcdd48c5984cef88c0a50a6b_grande.jpg"));
        playerList.add(new FootballPlayer(3, "N'Golo Kante", "19-11-2001", "2 năm", "Tiền vệ", "https://photo-cms-tpo.epicdn.me/w1200/Uploaded/2023/qhj-hiobgobrfc/2023_04_12/top-10-tien-ve-phong-ngu-xuat-sac-nhat-the-gioi-8-2266.jpg"));
        playerList.add(new FootballPlayer(4, "Erling Haaland", "19-11-2001", "2 năm", "Tiền đạo", "https://sportx.vn/wp-content/uploads/2023/06/tien_dao_hay_nhat_the_gioi__1__b9d6c01274454f9d86bfe366c76c1224_grande.jpg"));
        playerList.add(new FootballPlayer(6, "David De Gea", "19-11-2001", "2 năm", "Thủ môn", "https://ibongda.com.vn/wp-content/uploads/2022/10/Top-10-thu-mon-hay-nhat-the-gioi-1.jpg"));
    }

    @Override
    public List<FootballPlayer> findAll() {
        return playerList;
    }

    @Override
    public FootballPlayer findById(int id) {
        for (FootballPlayer footballPlayer : playerList) {
            if (footballPlayer.getId() == id) {
                return footballPlayer;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return playerList.remove(findById(id));
    }

    @Override
    public void create(FootballPlayer footballPlayer) {
        footballPlayer.setId(playerList.size() + 1);
        playerList.add(footballPlayer);
    }

    @Override
    public void edit(FootballPlayer footballPlayer) {
        for (FootballPlayer fb : playerList) {
            if (fb.getId() == footballPlayer.getId()) {
                fb.setId(footballPlayer.getId());
                fb.setName(footballPlayer.getName());
                fb.setDateOfBirth(footballPlayer.getDateOfBirth());
                fb.setExperience(footballPlayer.getExperience());
                fb.setLocation(footballPlayer.getLocation());
                fb.setImage(footballPlayer.getImage());
            }
        }
    }
}

