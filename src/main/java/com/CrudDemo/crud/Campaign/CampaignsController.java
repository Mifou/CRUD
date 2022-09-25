package com.CrudDemo.crud.Campaign;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignsController {


    private final CampaignRepository campaignRepository;

    public CampaignRepository getCampaignRepository() {
        return campaignRepository;
    }

    public CampaignsController(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @GetMapping
    public List<Campaign> getCampaigns() {
        return (List<Campaign>) campaignRepository.findAll();
    }

    @GetMapping("/{id}")
    public Campaign getCampaign(@PathVariable Long id) {
        return campaignRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) throws URISyntaxException {
        Campaign savedCampaign = campaignRepository.save(campaign);
        return ResponseEntity.created(new URI("'/campaigns/" + savedCampaign.getId())).body(savedCampaign);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCampaign(@PathVariable Long id, @RequestBody Campaign campaign) {
        Campaign currentCampaign = campaignRepository.findById(id).orElseThrow(RuntimeException::new);

        currentCampaign.setName(campaign.getName());
        currentCampaign.setCampaignFound(campaign.getCampaignFound());
        currentCampaign.setBidAmount(campaign.getBidAmount());
        currentCampaign.setKeywords(campaign.getKeywords());
        currentCampaign.setRadius(campaign.getRadius());
        currentCampaign.setStatus(campaign.isStatus());
        currentCampaign.setTown(campaign.getTown());
        currentCampaign = campaignRepository.save(currentCampaign);

        return ResponseEntity.ok(currentCampaign);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCampaign(@PathVariable Long id) {
        campaignRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
