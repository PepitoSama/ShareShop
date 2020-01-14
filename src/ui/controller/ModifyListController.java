package ui.controller;

import bl.facade.ShareShopFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.domain.products.GeneralProduct;
import model.domain.products.QuantifiedProduct;

/**
 *
 * @author pepito
 */
public class ModifyListController extends GridPane {

    private ShareShopFacade facade;

    @FXML
    private VBox shopListe;

    private final List<HBox> cellsl = new ArrayList();

    @FXML
    private ScrollPane productList;

    @FXML
    private ScrollPane favoris;

    @FXML
    private ScrollPane suggest;

    private VBox favorits;
    private VBox suggests;

    /**
     * ModifyListController constructor Display view ModifyShopListView in the
     * Main View
     *
     * @throws IOException
     */
    public ModifyListController() throws IOException {
	FXMLLoader leLoader = new FXMLLoader(getClass().getClassLoader().getResource("ui/view/ModifyShopListView.fxml"));
	leLoader.setController(this);
	leLoader.setRoot(this);
	leLoader.load();
	this.facade = ShareShopFacade.getInstance();
	shopListe = new VBox();
	initList();
	initFavorits();
	initSuggests();
    }

    private void initList() {
	List<QuantifiedProduct> shoplist = facade.getShopList();
	cellsl.clear();
	shopListe.getChildren().clear();
	for (QuantifiedProduct p : shoplist) {
	    HBox h = new HBox();
	    GeneralProduct prod = facade.getProductById(p.getIdProduct());
	    Label name = new Label(prod.getName());
	    name.setStyle("-fx-font-size: 24px; ");
	    name.setAlignment(Pos.CENTER);
	    Label quantity = new Label(Integer.toString(p.getQuantity()));
	    quantity.setStyle("-fx-font-size: 24px; ");
	    quantity.setAlignment(Pos.CENTER);
	    h.setSpacing(20);
	    Button add = new Button("+");
	    add.setStyle("-fx-font-size: 24px; ");
	    add.setAlignment(Pos.CENTER);
	    add.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    addOne(p);
		}
	    });
	    Button remove = new Button("-");
	    remove.setStyle("-fx-font-size: 24px; ");
	    remove.setAlignment(Pos.CENTER);
	    remove.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    removeOne(p, prod.getName());
		}
	    });
	    h.getChildren().add(name);
	    h.getChildren().add(remove);
	    h.getChildren().add(quantity);
	    h.getChildren().add(add);
	    cellsl.add(h);
	}
	if (shoplist.isEmpty()) {
	    Label mess = new Label("No product to buy");
	    mess.setStyle("-fx-font-size: 30px; ");
	    mess.setAlignment(Pos.CENTER);
	    HBox h = new HBox();
	    h.getChildren().add(mess);
	    cellsl.add(h);

	}
	shopListe.setAlignment(Pos.CENTER);
	shopListe.setSpacing(10.0);
	shopListe.getChildren().addAll(cellsl);
	shopListe.setAlignment(Pos.CENTER);
	productList.setContent(shopListe);
    }

    /**
     * FXML function back, return previous view
     *
     * @param event
     */
    @FXML
    void back(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new AfficherListController());
	} catch (IOException ex) {
	    Logger.getLogger(AfficherListController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    @FXML
    void addProduct(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new SearchProductsController());

	} catch (Exception ex) {
	    Logger.getLogger(SearchProductsController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    private void addOne(QuantifiedProduct p) {
	facade.addOne(p);
	initList();
    }

    private void removeOne(QuantifiedProduct p, String name) {
	if (p.getQuantity() == 1) {
	    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    alert.setTitle("Delete Product : " + name);
	    alert.setHeaderText("Are you're sure you want to remove this product from Shopping List?");
	    alert.setContentText("This shopping list will be definitly removed");
	    Optional<ButtonType> option = alert.showAndWait();
	    if (option.get() == null) {
	    } else if (option.get() == ButtonType.OK) {
		facade.removeProductInShopList(p);
	    }
	} else {
	    facade.removeOne(p);
	}
	initList();
    }

    private void initFavorits() {
	List<GeneralProduct> products = facade.getFavorites();
	favorits = new VBox();
	if (products.isEmpty()) {
	    favorits.getChildren().add(new Label("No product in favorit list"));
	}
	for (GeneralProduct p : products) {
	    GridPane h = new GridPane();

	    ColumnConstraints column1 = new ColumnConstraints();
	    column1.setPercentWidth(80);
	    h.getColumnConstraints().add(column1);

	    h.setId(p.getIdProduct() + "");

	    Button name = new Button(p.getName());
	    name.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    add(p);
		}
	    });
	    h.add(name, 0, 0);
	    h.setPrefWidth(favorits.getPrefWidth());
	    favorits.getChildren().add(h);
	}
	favoris.setContent(favorits);
    }

    private void initSuggests() {
	List<GeneralProduct> products = facade.getSuggest();
	suggests = new VBox();
	if (products.isEmpty()) {
	    suggests.getChildren().add(new Label("No product in suggest list"));
	}
	for (GeneralProduct p : products) {
	    GridPane h = new GridPane();

	    ColumnConstraints column1 = new ColumnConstraints();
	    column1.setPercentWidth(80);
	    h.getColumnConstraints().add(column1);

	    h.setId(p.getIdProduct() + "");

	    Button name = new Button(p.getName());
	    name.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    add(p);
		}
	    });
	    h.add(name, 0, 0);
	    h.setPrefWidth(suggests.getPrefWidth());
	    suggests.getChildren().add(h);
	}
	suggest.setContent(suggests);
    }

    private void add(GeneralProduct p) {
	List<GeneralProduct> liste = new ArrayList<>();
	liste.add(p);
	facade.addProductsToShopList(liste);
	initList();
    }

}
