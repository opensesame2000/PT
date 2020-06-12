/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since   26-05-2018
 */

package com.powertamil.lang.tamil;

import java.util.ArrayList;
import java.util.List;

public class TACE16 {

    // 3 Symbols and Fractions are omitted for TACE conversion purposes.
    public static ArrayList<Character> AllTACEList = new ArrayList<Character>();

    public final static char[] AllTACE = new char[]{'\uE100', '\uE101', '\uE102', '\uE103', '\uE104', '\uE105',
            '\uE106', '\uE107', '\uE10C', '\uE180', '\uE181', '\uE182', '\uE183', '\uE184', '\uE185', '\uE186',
            '\uE187', '\uE188', '\uE189', '\uE18A', '\uE18B', '\uE18C', '\uE1F0', '\uE1F2', '\uE1F3', '\uE1F4',
            '\uE1F5', '\uE1F6', '\uE1F7', '\uE1F8', '\uE1F9', '\uE1FA', '\uE1FB', '\uE1FC', '\uE201', '\uE202',
            '\uE203', '\uE204', '\uE205', '\uE206', '\uE207', '\uE208', '\uE209', '\uE20A', '\uE20B', '\uE20C',
            '\uE20D', '\uE210', '\uE211', '\uE212', '\uE213', '\uE214', '\uE215', '\uE216', '\uE217', '\uE218',
            '\uE219', '\uE21A', '\uE21B', '\uE21C', '\uE220', '\uE221', '\uE222', '\uE223', '\uE224', '\uE225',
            '\uE226', '\uE227', '\uE228', '\uE229', '\uE22A', '\uE22B', '\uE22C', '\uE230', '\uE231', '\uE232',
            '\uE233', '\uE234', '\uE235', '\uE236', '\uE237', '\uE238', '\uE239', '\uE23A', '\uE23B', '\uE23C',
            '\uE240', '\uE241', '\uE242', '\uE243', '\uE244', '\uE245', '\uE246', '\uE247', '\uE248', '\uE249',
            '\uE24A', '\uE24B', '\uE24C', '\uE250', '\uE251', '\uE252', '\uE253', '\uE254', '\uE255', '\uE256',
            '\uE257', '\uE258', '\uE259', '\uE25A', '\uE25B', '\uE25C', '\uE260', '\uE261', '\uE262', '\uE263',
            '\uE264', '\uE265', '\uE266', '\uE267', '\uE268', '\uE269', '\uE26A', '\uE26B', '\uE26C', '\uE270',
            '\uE271', '\uE272', '\uE273', '\uE274', '\uE275', '\uE276', '\uE277', '\uE278', '\uE279', '\uE27A',
            '\uE27B', '\uE27C', '\uE280', '\uE281', '\uE282', '\uE283', '\uE284', '\uE285', '\uE286', '\uE287',
            '\uE288', '\uE289', '\uE28A', '\uE28B', '\uE28C', '\uE290', '\uE291', '\uE292', '\uE293', '\uE294',
            '\uE295', '\uE296', '\uE297', '\uE298', '\uE299', '\uE29A', '\uE29B', '\uE29C', '\uE2A0', '\uE2A1',
            '\uE2A2', '\uE2A3', '\uE2A4', '\uE2A5', '\uE2A6', '\uE2A7', '\uE2A8', '\uE2A9', '\uE2AA', '\uE2AB',
            '\uE2AC', '\uE2B0', '\uE2B1', '\uE2B2', '\uE2B3', '\uE2B4', '\uE2B5', '\uE2B6', '\uE2B7', '\uE2B8',
            '\uE2B9', '\uE2BA', '\uE2BB', '\uE2BC', '\uE2C0', '\uE2C1', '\uE2C2', '\uE2C3', '\uE2C4', '\uE2C5',
            '\uE2C6', '\uE2C7', '\uE2C8', '\uE2C9', '\uE2CA', '\uE2CB', '\uE2CC', '\uE2D0', '\uE2D1', '\uE2D2',
            '\uE2D3', '\uE2D4', '\uE2D5', '\uE2D6', '\uE2D7', '\uE2D8', '\uE2D9', '\uE2DA', '\uE2DB', '\uE2DC',
            '\uE2E0', '\uE2E1', '\uE2E2', '\uE2E3', '\uE2E4', '\uE2E5', '\uE2E6', '\uE2E7', '\uE2E8', '\uE2E9',
            '\uE2EA', '\uE2EB', '\uE2EC', '\uE2F0', '\uE2F1', '\uE2F2', '\uE2F3', '\uE2F4', '\uE2F5', '\uE2F6',
            '\uE2F7', '\uE2F8', '\uE2F9', '\uE2FA', '\uE2FB', '\uE2FC', '\uE300', '\uE301', '\uE302', '\uE303',
            '\uE304', '\uE305', '\uE306', '\uE307', '\uE308', '\uE309', '\uE30A', '\uE30B', '\uE30C', '\uE310',
            '\uE311', '\uE312', '\uE313', '\uE314', '\uE315', '\uE316', '\uE317', '\uE318', '\uE319', '\uE31A',
            '\uE31B', '\uE31C', '\uE320', '\uE321', '\uE322', '\uE323', '\uE324', '\uE325', '\uE326', '\uE327',
            '\uE328', '\uE329', '\uE32A', '\uE32B', '\uE32C', '\uE330', '\uE331', '\uE332', '\uE333', '\uE334',
            '\uE335', '\uE336', '\uE337', '\uE338', '\uE339', '\uE33A', '\uE33B', '\uE33C', '\uE340', '\uE341',
            '\uE342', '\uE343', '\uE344', '\uE345', '\uE346', '\uE347', '\uE348', '\uE349', '\uE34A', '\uE34B',
            '\uE34C', '\uE350', '\uE351', '\uE352', '\uE353', '\uE354', '\uE355', '\uE356', '\uE357', '\uE358',
            '\uE359', '\uE35A', '\uE35B', '\uE35C', '\uE360', '\uE361', '\uE362', '\uE363', '\uE364', '\uE365',
            '\uE366', '\uE367', '\uE368', '\uE369', '\uE36A', '\uE36B', '\uE36C', '\uE370', '\uE371', '\uE372',
            '\uE373', '\uE374', '\uE375', '\uE376', '\uE377', '\uE378', '\uE379', '\uE37A', '\uE37B', '\uE37C',
            '\uE380', '\uE381', '\uE382', '\uE383', '\uE384', '\uE385', '\uE386', '\uE387', '\uE388', '\uE389',
            '\uE38A', '\uE38B', '\uE38C', '\uE38D'};

    // Empty and Future Code Points are omitted for Codec purposes for now.
    public final static char[] Empty_Spots = new char[]{
            '\uE390', '\uE391', '\uE392', '\uE393', '\uE394', '\uE395', '\uE396',
            '\uE397', '\uE398', '\uE399', '\uE39A', '\uE39B', '\uE39C', '\uE39D', '\uE39E', '\uE39F', '\uE3A0',
            '\uE3A1', '\uE3A2', '\uE3A3', '\uE3A4', '\uE3A5', '\uE3A6', '\uE3A7', '\uE3A8', '\uE3A9', '\uE3AA',
            '\uE3AB', '\uE3AC', '\uE3AD', '\uE3AE', '\uE3AF', '\uE3B0', '\uE3B1', '\uE3B2', '\uE3B3', '\uE3B4',
            '\uE3B5', '\uE3B6', '\uE3B7', '\uE3B8', '\uE3B9', '\uE3BA', '\uE3BB', '\uE3BC', '\uE3BD', '\uE3BE',
            '\uE3BF', '\uE3C0', '\uE3C1', '\uE3C2', '\uE3C3', '\uE3C4', '\uE3C5', '\uE3C6', '\uE3C7', '\uE3C8',
            '\uE3C9', '\uE3CA', '\uE3CB', '\uE3CC', '\uE3CD', '\uE3CE', '\uE3CF', '\uE3D0', '\uE3D1', '\uE3D2',
            '\uE3D3', '\uE3D4', '\uE3D5', '\uE3D6', '\uE3D7', '\uE3D8', '\uE3D9', '\uE3DA', '\uE3DB', '\uE3DC',
            '\uE3DD', '\uE3DE', '\uE3DF', '\uE3E0', '\uE3E1', '\uE3E2', '\uE3E3', '\uE3E4', '\uE3E5', '\uE3E6',
            '\uE3E7', '\uE3E8', '\uE3E9', '\uE3EA', '\uE3EB', '\uE3EC', '\uE3ED', '\uE3EE', '\uE3EF', '\uE3F0',
            '\uE3F1', '\uE3F2', '\uE3F3', '\uE3F4', '\uE3F5', '\uE3F6', '\uE3F7', '\uE3F8', '\uE3F9', '\uE3FA',
            '\uE3FB', '\uE3FC', '\uE3FD', '\uE3FE', '\uE3FF'
    };

    public final static char[] Future_Spots = new char[]{
            '\uE10D', '\uE10E', '\uE10F', '\uE18D', '\uE18E', '\uE18F',
            '\uE1F1', '\uE1FD', '\uE1FE', '\uE1FF', '\uE200', '\uE20E', '\uE20F', '\uE21D', '\uE21E', '\uE21F',
            '\uE22D', '\uE22E', '\uE22F', '\uE23D', '\uE23E', '\uE23F', '\uE24D', '\uE24E', '\uE24F', '\uE25D',
            '\uE25E', '\uE25F', '\uE26D', '\uE26E', '\uE26F', '\uE27D', '\uE27E', '\uE27F', '\uE28D', '\uE28E',
            '\uE28F', '\uE29D', '\uE29E', '\uE29F', '\uE2AD', '\uE2AE', '\uE2AF', '\uE2BD', '\uE2BE', '\uE2BF',
            '\uE2CD', '\uE2CE', '\uE2CF', '\uE2DD', '\uE2DE', '\uE2DF', '\uE2ED', '\uE2EE', '\uE2EF', '\uE2FD',
            '\uE2FE', '\uE2FF', '\uE30D', '\uE30E', '\uE30F', '\uE31D', '\uE31E', '\uE31F', '\uE32D', '\uE32E',
            '\uE32F', '\uE33D', '\uE33E', '\uE33F', '\uE34D', '\uE34E', '\uE34F', '\uE35D', '\uE35E', '\uE35F',
            '\uE36D', '\uE36E', '\uE36F', '\uE37D', '\uE37E', '\uE37F', '\uE38E', '\uE38F'
    };

    static {
        for (int g = 0; g < AllTACE.length; g++) {
            AllTACEList.add(AllTACE[g]);
        }
    }

    public static List<Character> getAllTACEList() {
        return AllTACEList;
    }

}
